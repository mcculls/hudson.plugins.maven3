/*******************************************************************************
 *
 * Copyright (c) 2010-2011 Sonatype, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: 
 *
 *   
 *     
 *
 *******************************************************************************/ 

package org.hudsonci.maven.plugin;

import com.google.inject.Key;

import org.hudsonci.inject.Smoothie;
import org.hudsonci.maven.model.UniqueList;
import org.hudsonci.maven.plugin.artifactrecorder.ArtifactArchiver;
import org.hudsonci.maven.plugin.artifactrecorder.ArtifactFingerprinter;
import org.hudsonci.maven.plugin.builder.BuildStateRecord;
import org.hudsonci.maven.plugin.builder.MavenBuildAction;
import org.hudsonci.maven.plugin.builder.MavenBuilder;
import org.hudsonci.maven.plugin.builder.MavenBuilderDescriptor;
import org.hudsonci.maven.plugin.dependencymonitor.DependencyNotifier;
import org.hudsonci.maven.plugin.dependencymonitor.DependencyTrigger;
import org.hudsonci.maven.plugin.install.MavenInstallation;
import org.hudsonci.utils.marshal.XStreamMarshaller;
import org.hudsonci.utils.marshal.xref.FileXReferenceStore;
import org.hudsonci.utils.marshal.xref.XReferenceConverter;
import org.hudsonci.utils.marshal.xref.XReferenceStoreConverter;
import org.hudsonci.maven.model.state.BuildStateDTO;

import com.thoughtworks.xstream.XStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hudson.Plugin;
import hudson.XmlFile;
import hudson.model.Items;
import hudson.model.Run;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Hudson Maven plugin.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 2.1.0
 */
@Named
@Singleton
public class MavenPlugin
    extends Plugin
{
    private static final Logger log = LoggerFactory.getLogger(MavenPlugin.class);

    @Override
    public void start() throws Exception {
        // Setup the marshaller which will handle persisting referenced data
        // Do not use XStream2... causes problems with @XStreamImplicit (used in UniqueList)
        XStream xs = new XStream();
        xs.setClassLoader(getClass().getClassLoader());
        xs.processAnnotations(new Class[] {
            BuildStateDTO.class,
            UniqueList.class
        });
        XStreamMarshaller marshaller = new XStreamMarshaller(xs);

        // Setup the reference converter
        FileXReferenceStore store = new FileXReferenceStore(marshaller);
        XReferenceStoreConverter converter = new XReferenceStoreConverter(
                store, Run.XSTREAM.getMapper(), Run.XSTREAM.getReflectionProvider())
        {
            @Override
            public boolean canConvert(final Class type) {
                return type == BuildStateRecord.StateReference.class;
            }
        };
        converter.setHolderType(XReferenceConverter.HolderType.SOFT);

        // Configure the standard xstream instance to know about our converter plus type configuration
        Run.XSTREAM.registerConverter(converter);

        Run.XSTREAM.processAnnotations(new Class[] {
            MavenBuildAction.class,
            BuildStateRecord.class
        });

        Items.XSTREAM.processAnnotations(new Class[] {
            MavenBuilder.class,
            DependencyNotifier.class,
            DependencyTrigger.class,
            ArtifactFingerprinter.class,
            ArtifactArchiver.class
        });

        XmlFile.DEFAULT_XSTREAM.processAnnotations(new Class[] {
            MavenBuilderDescriptor.class,
            MavenInstallation.class
        });
    }
}
