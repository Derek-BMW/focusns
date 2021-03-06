package org.focusns.service.core.impl;

/*
 * #%L
 * FocusSNS Runtime
 * %%
 * Copyright (C) 2011 - 2013 FocusSNS
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 2.1 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */

import org.focusns.common.event.Event;
import org.focusns.dao.core.ProjectDao;
import org.focusns.model.common.Caches;
import org.focusns.model.core.Project;
import org.focusns.service.core.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Cacheable(value = Caches.PROJECT, key = "#id")
    public Project getProject(long id) {
        return projectDao.select(id);
    }

    @Cacheable(value = Caches.PROJECT, key = "#code")
    public Project getProject(String code) {
        return projectDao.selectByCode(code);
    }

    public void createProject(Project project) {
        projectDao.insert(project);
    }

    @Caching(evict = { @CacheEvict(value = Caches.PROJECT, key = "#project.id"), @CacheEvict(value = Caches.PROJECT, key = "#project.code") })
    public void removeProject(Project project) {
        projectDao.delete(project.getId());
    }

    @Caching(evict = { @CacheEvict(value = Caches.PROJECT, key = "#project.id"), @CacheEvict(value = Caches.PROJECT, key = "#project.code") })
    public void modifyProject(Project project) {
        projectDao.update(project);
    }

}
