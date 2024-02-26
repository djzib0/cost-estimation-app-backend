package cost.estimation.app.service;

import cost.estimation.app.entity.ProjectType;
import cost.estimation.app.repository.ProjectTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTypeService {

    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    public List<ProjectType> getAllProjectTypes() {
        return projectTypeRepository.findAll();
    }
}
