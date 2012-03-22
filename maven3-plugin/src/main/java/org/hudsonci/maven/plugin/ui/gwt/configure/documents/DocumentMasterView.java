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

import org.hudsonci.maven.plugin.ui.gwt.configure.documents.internal.DocumentMasterViewImpl;
import org.hudsonci.maven.plugin.ui.gwt.configure.workspace.WorkspaceView;

import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.view.client.HasData;
import com.google.inject.ImplementedBy;

/**
 * Provides the UI for editing documents.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 2.1.0
 */
@ImplementedBy(DocumentMasterViewImpl.class)
public interface DocumentMasterView
    extends WorkspaceView
{
    @DefaultLocale("en_US")
    interface MessagesResource
        extends Messages
    {
        @DefaultMessage("Documents")
        String documents();

        @DefaultMessage("Refresh")
        String refresh();

        @DefaultMessage("Add")
        String add();

        @DefaultMessage("Remove")
        String remove();

        @DefaultMessage("ID")
        String id();

        @DefaultMessage("Type")
        String type();

        @DefaultMessage("Name")
        String name();

        @DefaultMessage("Please add or select a document.")
        String detailSummary();
    }

    void setPresenter(DocumentMasterPresenter presenter);

    HasData<Document> getDocumentDataContainer();

    void setDocumentDetailView(DocumentDetailView view);

    void setDocumentSelected(boolean flag);

    void scrollToNewDocument();
}
