package cost.estimation.app.service;

import cost.estimation.app.entity.Outsourcing;
import cost.estimation.app.repository.OutsourcingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutsourcingService {

    @Autowired
    private OutsourcingRepository outsourcingRepository;

    public List<Outsourcing> getAllOutsourcingByProjectId(Long projectId) {
        return outsourcingRepository.findAllByProjectId(projectId);
    }

    public List<Outsourcing> getAllOutsourcing() {
        return outsourcingRepository.findAll();
    }

    public Outsourcing addOutsourcing(Outsourcing newOutsourcing) {
        return outsourcingRepository.save(newOutsourcing);
    }

    @Transactional
    public Outsourcing editOutsourcing(Outsourcing editedOutsourcing) {
        Outsourcing newOutsourcing = outsourcingRepository.findById(editedOutsourcing.getOutsourcingId()).orElseThrow();
        newOutsourcing.setOutsourcingName(editedOutsourcing.getOutsourcingName());
        newOutsourcing.setContractorName(editedOutsourcing.getContractorName());
        newOutsourcing.setOutsourcingValue(editedOutsourcing.getOutsourcingValue());
        newOutsourcing.setRemark(editedOutsourcing.getRemark());
        newOutsourcing.setProjectId(editedOutsourcing.getProjectId());

        return newOutsourcing;
    }

    public void deleteOutsourcing(Long outsourcingId) {
        outsourcingRepository.deleteById(outsourcingId);
    }
}
