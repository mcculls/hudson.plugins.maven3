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

package org.hudsonci.maven.eventspy_30.handler;

import javax.inject.Named;

import org.hudsonci.maven.eventspy_30.EventSpyHandler;
import org.hudsonci.maven.eventspy_30.LifecycleDebugLoggerImpl.ProjectPlanEvent;

/**
 * Handles {@link ProjectPlanEvent} events.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 2.1.0
 */
@Named
public class ProjectPlanEventHandler
    extends EventSpyHandler<ProjectPlanEvent>
{
    public void handle(final ProjectPlanEvent event) throws Exception {
        log.debug("Project plan: {}", event);
    }
}
