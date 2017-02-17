package io.objectbox.reactive;

/**
 * Transforms or processes data before it is given to subscribed {@link DataObserver}s. A transformer is set via
 * {@link SubscriptionBuilder#transform(DataTransformer)}.
 *
 * Note that a transformer does is not necessarily required to actually "transform" any data.
 * Technically, it's fine to return the same data it received and just do some processing with it.
 *
 * Threading notes: Note that the transformer is always executed asynchronously.
 * It is OK to perform long lasting operations.
 *
 * @param <FROM> Data type this transformer receives
 * @param <TO> Type of transformed data
 */
public interface DataTransformer<FROM, TO> {
    /**
     * Transforms/processes the given data.
     * @param source data to be transformed
     * @return transformed data
     * @throws Exception Transformers may throw any exceptions, which can be reacted on via
     * {@link SubscriptionBuilder#onError(ErrorObserver)}.
     */
    TO transform(FROM source) throws Exception;
}
