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

import com.google.gwt.user.cellview.client.TextColumn;

import org.hudsonci.gwt.common.MaximizedCellTable;
import org.hudsonci.maven.model.PropertiesDTO;
import org.hudsonci.maven.model.PropertiesDTO.Entry;

/**
 * Table to display {@link PropertiesDTO.Entry} items.
 * 
 * @author Jamie Whitehouse
 * @since 2.1.0
 */
public class PropertiesTable extends MaximizedCellTable<Entry> 
{
    public PropertiesTable()
    {
        createColumns();
    }
    
    private void createColumns()
    {
        addColumn( new TextColumn<Entry>()
        {
            @Override
            public String getValue( Entry entry )
            {
                return entry.getName();
            }
        }, "Name" );
        
        addColumn( new TextColumn<Entry>()
        {
            @Override
            public String getValue( Entry entry )
            {
                return entry.getValue();
            }
        }, "Value" );
    }
}
