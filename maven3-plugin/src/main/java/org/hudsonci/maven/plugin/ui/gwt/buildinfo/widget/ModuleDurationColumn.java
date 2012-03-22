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

import org.hudsonci.maven.plugin.ui.gwt.buildinfo.ModuleFormatter;

import com.google.gwt.user.cellview.client.TextColumn;
import org.hudsonci.maven.model.state.MavenProjectDTO;

/**
 * Column to display the duration of a {@link MavenProjectDTO} build.
 * 
 * @author Jamie Whitehouse
 * @since 2.1.0
 */
public class ModuleDurationColumn
    extends TextColumn<MavenProjectDTO>
{
    public ModuleDurationColumn()
    {
        super();
        setHorizontalAlignment( ALIGN_RIGHT );
    }
    
    @Override
    public String getValue( MavenProjectDTO module )
    {
        return new ModuleFormatter( module ).duration();
    }
}
