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

package org.hudsonci.maven.plugin.documents;

/**
 * Thrown to indicate a failure with the document sub-system.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 2.1.0
 */
public class DocumentException
    extends RuntimeException
{
    public DocumentException() {
        super();
    }

    public DocumentException(final String message) {
        super(message);
    }

    public DocumentException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DocumentException(final Throwable cause) {
        super(cause);
    }
}
