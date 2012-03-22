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

package org.hudsonci.maven.plugin.builder;

import org.hudsonci.service.NotFoundException;

/**
 * Thrown when a requested build-state or a collection of build-states is not found.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 2.1.0
 */
public class BuildStateNotFoundException
    extends NotFoundException
{
    public BuildStateNotFoundException(final String projectName, final int buildNumber, final int index) {
        super(String.format("No such build state for %s #%s at index %s", projectName, buildNumber, index));
    }

    public BuildStateNotFoundException(final String projectName, final int buildNumber) {
        super(String.format("No build states for %s #%s", projectName, buildNumber));
    }
}
