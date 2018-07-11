/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.sip.ipaccesscontrollist;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class IpAddressUpdater extends Updater<IpAddress> {
    private String pathAccountSid;
    private final String pathIpAccessControlListSid;
    private final String pathSid;
    private String ipAddress;
    private String friendlyName;
    private Integer cidrPrefixLength;

    /**
     * Construct a new IpAddressUpdater.
     * 
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @param pathSid The sid
     */
    public IpAddressUpdater(final String pathIpAccessControlListSid, 
                            final String pathSid) {
        this.pathIpAccessControlListSid = pathIpAccessControlListSid;
        this.pathSid = pathSid;
    }

    /**
     * Construct a new IpAddressUpdater.
     * 
     * @param pathAccountSid The account_sid
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @param pathSid The sid
     */
    public IpAddressUpdater(final String pathAccountSid, 
                            final String pathIpAccessControlListSid, 
                            final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathIpAccessControlListSid = pathIpAccessControlListSid;
        this.pathSid = pathSid;
    }

    /**
     * The ip_address.
     * 
     * @param ipAddress The ip_address
     * @return this
     */
    public IpAddressUpdater setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    /**
     * The friendly_name.
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public IpAddressUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The cidr_prefix_length.
     * 
     * @param cidrPrefixLength The cidr_prefix_length
     * @return this
     */
    public IpAddressUpdater setCidrPrefixLength(final Integer cidrPrefixLength) {
        this.cidrPrefixLength = cidrPrefixLength;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated IpAddress
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public IpAddress update(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/SIP/IpAccessControlLists/" + this.pathIpAccessControlListSid + "/IpAddresses/" + this.pathSid + ".json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("IpAddress update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return IpAddress.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (ipAddress != null) {
            request.addPostParam("IpAddress", ipAddress);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (cidrPrefixLength != null) {
            request.addPostParam("CidrPrefixLength", cidrPrefixLength.toString());
        }
    }
}