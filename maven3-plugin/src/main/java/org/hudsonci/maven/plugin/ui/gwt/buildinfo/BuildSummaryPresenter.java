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

package org.hudsonci.maven.plugin.ui.gwt.buildinfo;

import org.hudsonci.maven.plugin.ui.gwt.buildinfo.internal.BuildSummaryPresenterImpl;
import org.hudsonci.maven.plugin.ui.gwt.buildinfo.internal.BuildSummaryViewImpl;
import org.hudsonci.maven.plugin.ui.gwt.buildinfo.internal.ModuleDataProvider;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;
import org.hudsonci.maven.model.state.BuildStateDTO;

/**
 * Display summary information about a build.
 * 
 * @author Jamie Whitehouse
 * @since 2.1.0
 */
@ImplementedBy(BuildSummaryPresenterImpl.class)
public interface BuildSummaryPresenter
{
    @ImplementedBy(BuildSummaryViewImpl.class)
    public interface BuildSummaryView
        extends IsWidget
    {
        void setModuleData(ModuleDataProvider dataProvider);

        void setBuildSummaryText(String summaryText);
    }

    void setBuildState(BuildStateDTO buildState);
}
