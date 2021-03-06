package eu.cloud.cloudopting.service.impl;

import eu.cloud.cloudopting.domain.Applications;
import eu.cloud.cloudopting.repository.ApplicationsRepository;
import eu.cloud.cloudopting.service.ApplicationService;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import ro.tn.events.api.service.AbstractService;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * @author Daniel P.
 */
@Service
@Transactional
public class ApplicationServiceImpl extends AbstractService<Applications> implements ApplicationService {

    @Inject
    private ApplicationsRepository applicationsRepository;

    /**
     * Constructorul service-ului.
     */
    public ApplicationServiceImpl() {
        super(Applications.class);
    }

    @Override
    protected PagingAndSortingRepository<Applications, Long> getDao() {
        return applicationsRepository;
    }

    @Override
    protected JpaSpecificationExecutor<Applications> getSpecificationExecutor() {
        return applicationsRepository;
    }
}
