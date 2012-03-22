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

package org.hudsonci.maven.plugin.ui.gwt.buildinfo.event;

import org.hudsonci.gwt.common.EventSupport;
import org.hudsonci.maven.plugin.ui.gwt.buildinfo.event.BuildStateSelectedEvent.Handler;

import com.google.gwt.event.shared.EventHandler;
import org.hudsonci.maven.model.state.BuildStateDTO;

/**
 * Indicates that a {@link BuildStateDTO} has been selected.
 * 
 * @author Jamie Whitehouse
 * @since 2.1.0
 */
public class BuildStateSelectedEvent
    extends EventSupport<Handler>
{
    /**
     * Handler interface for {@link BuildStateSelectedEvent} events.
     */
    public static interface Handler
        extends EventHandler
    {
        void onSelected( BuildStateSelectedEvent event );
    }

    public static Type<Handler> TYPE = new Type<Handler>();

    private final BuildStateDTO state;

    public BuildStateSelectedEvent( final BuildStateDTO selectedState )
    {
        super(TYPE);
        this.state = selectedState;
    }

    public BuildStateDTO getBuildState()
    {
        return state;
    }

    @Override
    public Type<Handler> getAssociatedType()
    {
        return TYPE;
    }

    @Override
    protected void dispatch( Handler handler )
    {
        handler.onSelected( this );
    }
}
