/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.events.v1.subscription;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class SubscribedEventCreator extends Creator<SubscribedEvent> {
    private final String pathSubscriptionSid;
    private final String type;
    private Integer version;

    /**
     * Construct a new SubscribedEventCreator.
     *
     * @param pathSubscriptionSid The subscription_sid
     * @param type The type
     */
    public SubscribedEventCreator(final String pathSubscriptionSid,
                                  final String type) {
        this.pathSubscriptionSid = pathSubscriptionSid;
        this.type = type;
    }

    /**
     * The version.
     *
     * @param version The version
     * @return this
     */
    public SubscribedEventCreator setVersion(final Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created SubscribedEvent
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public SubscribedEvent create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.EVENTS.toString(),
            "/v1/Subscriptions/" + this.pathSubscriptionSid + "/SubscribedEvents"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SubscribedEvent creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return SubscribedEvent.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (type != null) {
            request.addPostParam("Type", type);
        }

        if (version != null) {
            request.addPostParam("Version", version.toString());
        }
    }
}