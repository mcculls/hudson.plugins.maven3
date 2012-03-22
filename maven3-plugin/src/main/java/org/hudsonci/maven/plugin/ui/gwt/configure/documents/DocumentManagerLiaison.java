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

package org.hudsonci.maven.plugin.ui.gwt.configure.documents;

import org.hudsonci.maven.plugin.ui.gwt.configure.documents.internal.DocumentManagerLiaisonImpl;

import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.view.client.AbstractDataProvider;
import com.google.inject.ImplementedBy;

/**
 * Provides access to the {@link org.hudsonci.maven.plugin.documents.DocumentManager}.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 2.1.0
 */
@ImplementedBy(DocumentManagerLiaisonImpl.class)
public interface DocumentManagerLiaison
{
    @DefaultLocale("en_US")
    interface MessagesResource
        extends Messages
    {
        @DefaultMessage("Failed to fetch all documents")
        String documentFetchAllFailed();

        @DefaultMessage("Failed to add document")
        String documentAddFailed();

        @DefaultMessage("Failed to update document")
        String documentUpdateFailed();

        @DefaultMessage("Failed to remove document")
        String documentRemoveFailed();
    }

    /**
     * Get the data-provider for document data.
     */
    AbstractDataProvider<Document> getDataProvider();

    /**
     * Fetch all documents.
     */
    void fetchAll();

    /**
     * Create a new temporal document.
     */
    Document create();

    /**
     * Add or update the document based on its state.
     */
    void save(Document document);

    /**
     * Add a new document.
     */
    void add(Document document);

    /**
     * Update an existing document.
     */
    void update(Document document);

    /**
     * Remove an existing document.
     */
    void remove(Document document);
}
