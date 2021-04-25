package com.example.demo.application.provider;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.application.domain.Project;
import com.example.demo.application.exception.ProjectDetailsNotFoundException;
import com.example.demo.application.repository.ProjectDetailsRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectDetailsProvider {
    private final ProjectDetailsRepository projectDetailsRepository;
    public List<ProjectDetails> getAllProjectDetails() {
        try{
            return getListOfProjectDetails(projectDetailsRepository.findAll());
        }catch(RuntimeException e){
            throw new ProjectDetailsNotFoundException(e.getMessage());
        }
    }
    private List<ProjectDetails> getListOfProjectDetails(List<Project> findAll) {
        List<ProjectDetails> projectDetailsList = new ArrayList<>();
        findAll.forEach(project -> projectDetailsList.add(ProjectDetails.builder()
        .id(project.getId())
        .projectDescription(project.getProjectDescription())
        .projectTitle(project.getProjectTitle())
        .projectSourceLink(project.getProjectSourceUrl())
        .build()));
        return projectDetailsList;
    }
    
}
