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

package org.hudsonci.maven.plugin.ui.gwt.buildinfo.widget;

/**
 * Column to display the status of a {@link MavenProjectDTO} build.
 * 
 * @author Jamie Whitehouse
 * @since 2.1.0
 */
import org.hudsonci.gwt.common.ImageResourceColumn;
import org.hudsonci.maven.plugin.ui.gwt.buildinfo.BuildInfoResources;
import org.hudsonci.maven.plugin.ui.gwt.buildinfo.ModuleFormatter;

import com.google.gwt.resources.client.ImageResource;
import org.hudsonci.maven.model.state.MavenProjectDTO;

public class ModuleStatusIconColumn
    extends ImageResourceColumn<MavenProjectDTO>
{
    @Override
    public ImageResource getValue( MavenProjectDTO module )
    {
        return new ModuleFormatter( module ).statusIcon( BuildInfoResources.INSTANCE );
    }
}
