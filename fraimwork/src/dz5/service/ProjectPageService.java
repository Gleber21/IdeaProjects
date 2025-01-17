package dz5.service;

import dz5.controller.ProjectPageDto;
import dz5.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectPageService {

    private final ProjectService projectService;

    public List<ProjectPageDto> findAllProjects() {
        return projectService.getAllProjects()
                .stream()
                .map(this::convert).toList();
    }

    public Optional<ProjectPageDto> findProjectById(Long id) {
        return projectService.getProjectById(id)
                .map(this::convert);
    }

    private ProjectPageDto convert(Project project) {
        ProjectPageDto projectPageDto = new ProjectPageDto();

        projectPageDto.setId(String.valueOf(project.getId()));
        projectPageDto.setName(project.getProjectName());

        return projectPageDto;
    }
}
