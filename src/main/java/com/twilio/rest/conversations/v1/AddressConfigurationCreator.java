/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.util.List;

import java.util.List;



public class AddressConfigurationCreator extends Creator<AddressConfiguration>{
    private AddressConfiguration.Type type;
    private String address;
    private String friendlyName;
    private Boolean autoCreationEnabled;
    private AddressConfiguration.AutoCreationType autoCreationType;
    private String autoCreationConversationServiceSid;
    private String autoCreationWebhookUrl;
    private AddressConfiguration.Method autoCreationWebhookMethod;
    private List<String> autoCreationWebhookFilters;
    private String autoCreationStudioFlowSid;
    private Integer autoCreationStudioRetryCount;

    public AddressConfigurationCreator(final AddressConfiguration.Type type, final String address) {
        this.type = type;
        this.address = address;
    }

    public AddressConfigurationCreator setType(final AddressConfiguration.Type type){
        this.type = type;
        return this;
    }
    public AddressConfigurationCreator setAddress(final String address){
        this.address = address;
        return this;
    }
    public AddressConfigurationCreator setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public AddressConfigurationCreator setAutoCreationEnabled(final Boolean autoCreationEnabled){
        this.autoCreationEnabled = autoCreationEnabled;
        return this;
    }
    public AddressConfigurationCreator setAutoCreationType(final AddressConfiguration.AutoCreationType autoCreationType){
        this.autoCreationType = autoCreationType;
        return this;
    }
    public AddressConfigurationCreator setAutoCreationConversationServiceSid(final String autoCreationConversationServiceSid){
        this.autoCreationConversationServiceSid = autoCreationConversationServiceSid;
        return this;
    }
    public AddressConfigurationCreator setAutoCreationWebhookUrl(final String autoCreationWebhookUrl){
        this.autoCreationWebhookUrl = autoCreationWebhookUrl;
        return this;
    }
    public AddressConfigurationCreator setAutoCreationWebhookMethod(final AddressConfiguration.Method autoCreationWebhookMethod){
        this.autoCreationWebhookMethod = autoCreationWebhookMethod;
        return this;
    }
    public AddressConfigurationCreator setAutoCreationWebhookFilters(final List<String> autoCreationWebhookFilters){
        this.autoCreationWebhookFilters = autoCreationWebhookFilters;
        return this;
    }
    public AddressConfigurationCreator setAutoCreationWebhookFilters(final String autoCreationWebhookFilters){
        return setAutoCreationWebhookFilters(Promoter.listOfOne(autoCreationWebhookFilters));
    }
    public AddressConfigurationCreator setAutoCreationStudioFlowSid(final String autoCreationStudioFlowSid){
        this.autoCreationStudioFlowSid = autoCreationStudioFlowSid;
        return this;
    }
    public AddressConfigurationCreator setAutoCreationStudioRetryCount(final Integer autoCreationStudioRetryCount){
        this.autoCreationStudioRetryCount = autoCreationStudioRetryCount;
        return this;
    }

    @Override
    public AddressConfiguration create(final TwilioRestClient client){
        String path = "/v1/Configuration/Addresses";

        path = path.replace("{"+"Type"+"}", this.type.toString());
        path = path.replace("{"+"Address"+"}", this.address.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.CONVERSATIONS.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("AddressConfiguration creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return AddressConfiguration.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (type != null) {
            request.addPostParam("Type", type.toString());
    
        }
        if (address != null) {
            request.addPostParam("Address", address);
    
        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (autoCreationEnabled != null) {
            request.addPostParam("AutoCreationEnabled", autoCreationEnabled.toString());
    
        }
        if (autoCreationType != null) {
            request.addPostParam("AutoCreationType", autoCreationType.toString());
    
        }
        if (autoCreationConversationServiceSid != null) {
            request.addPostParam("AutoCreation.ConversationServiceSid", autoCreationConversationServiceSid);
    
        }
        if (autoCreationWebhookUrl != null) {
            request.addPostParam("AutoCreation.WebhookUrl", autoCreationWebhookUrl);
    
        }
        if (autoCreationWebhookMethod != null) {
            request.addPostParam("AutoCreationWebhookMethod", autoCreationWebhookMethod.toString());
    
        }
        if (autoCreationWebhookFilters != null) {
            for (String prop : autoCreationWebhookFilters) {
                request.addPostParam("AutoCreation.WebhookFilters", prop);
            }
    
        }
        if (autoCreationStudioFlowSid != null) {
            request.addPostParam("AutoCreation.StudioFlowSid", autoCreationStudioFlowSid);
    
        }
        if (autoCreationStudioRetryCount != null) {
            request.addPostParam("AutoCreationStudioRetryCount", autoCreationStudioRetryCount.toString());
    
        }
    }
}
