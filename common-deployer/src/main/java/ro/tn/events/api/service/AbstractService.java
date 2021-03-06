package ro.tn.events.api.service;

import ro.tn.events.api.entity.BaseEntity;

/**
 * @author Daniel P.
 *         Date: 8/8/13
 * @param <T> entitatea service-ului
 */
public abstract class AbstractService<T extends BaseEntity> extends AbstractDefaultService<T> {
    /**
     * Constructorul service-ului.
     *
     * @param clazzToSet clasa entitatii
     */
    public AbstractService(final Class<T> clazzToSet) {
        super(clazzToSet);
    }
}
