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

package org.hudsonci.maven.model.state;

import java.io.File;

import org.hudsonci.maven.model.state.ArtifactDTO;

/**
 * Helper for {@link ArtifactDTO}.
 * 
 * @author Jamie Whitehouse
 * @since 2.1.0
 */
public class ArtifactDTOHelper
{
    /**
     * Creates a {@link File} for the artifacts location if available.
     * 
     * An artifact may not have a file location when it has been recorded for use but not found in a Maven repo, hence 
     * not resolved to the local repository/file system.
     *  
     * @return a {@link File} representing the artifacts location or null if the artifact has no file location.
     */
    public static File getFile(ArtifactDTO artifact) {
        String filePath = artifact.getRepositoryFile();
        return (filePath == null ? null : new File(filePath));
    }
}
