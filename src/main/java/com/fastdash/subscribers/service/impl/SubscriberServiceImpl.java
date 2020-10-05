package com.fastdash.subscribers.service.impl;

import com.fastdash.subscribers.rest.request.*;
import com.fastdash.subscribers.service.RestService;
import com.fastdash.subscribers.service.SubscriberService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("subscriberService")
@PropertySource("classpath:application.properties")
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private RestService restService;

    @Value( "${moosend.subscribers.url}" )
    private String msUrl;

    @Value( "${mailerlite.subscribers.url}" )
    private String mailerliteSubscribersUrl;

    @Value( "${sendfox.subscribers.url}" )
    private String sendFoxSubscribersUrl;

    @Value( "${moosend.authorization.key}" )
    private String mskey;

    @Value( "${mailerlite.authorization.key}" )
    private String sendMLAuthorizationKey;

    @Value( "${sendfox.authorization.key}" )
    private String sfkey;

    @Override
    public String updateMoosendMailerLiteSubscribers() {
        String moosendSubscribersUrl = msUrl + "?apikey=" + mskey;

        String moosendSubscribers = restService.getSubscriberListJSON(moosendSubscribersUrl, "", "");
        Gson g = new Gson();
        MSGetSubscriberRequest msGetSubscriberRequest = g.fromJson(moosendSubscribers, MSGetSubscriberRequest.class);
        String mailerliteSubscribers = restService.getSubscriberListJSON(mailerliteSubscribersUrl, "X-MailerLite-ApiKey", sendMLAuthorizationKey);
        MLGetSubscriberRequest[] mlGetSubscriberRequest = g.fromJson(mailerliteSubscribers, MLGetSubscriberRequest[].class);

        updateMailerLiteSubscribers(msGetSubscriberRequest.getContext(), mlGetSubscriberRequest);
        return "Finish update MailerLite Subscribers";
    }

    @Override
    public String updateSendFoxMailerLiteSubscribers() {
        String sendFoxAuthorizationKey = "Bearer " + sfkey;;
        String sendFoxSubscribers = restService.getSubscriberListJSON(sendFoxSubscribersUrl, "Authorization", sendFoxAuthorizationKey);
        Gson g = new Gson();
        SFGetSubscriberRequest sfGetSubscriberRequest = g.fromJson(sendFoxSubscribers, SFGetSubscriberRequest.class);

        String mailerliteSubscribers = restService.getSubscriberListJSON(mailerliteSubscribersUrl, "X-MailerLite-ApiKey", sendMLAuthorizationKey);
        MLGetSubscriberRequest[] mlGetSubscriberRequest = g.fromJson(mailerliteSubscribers, MLGetSubscriberRequest[].class);

        updateSendFoxSubscribers(sfGetSubscriberRequest, mlGetSubscriberRequest);
        return "Finish update SendFox Subscribers";
    }

    private void updateSendFoxSubscribers(SFGetSubscriberRequest sfGetSubscriberRequest, MLGetSubscriberRequest[] mlGetSubscriberRequest){
        String sendFoxAuthorizationKey = "Bearer " + sfkey;;
        SendFoxContact[] sfGetSubscribers = sfGetSubscriberRequest.getData();
        for (MLGetSubscriberRequest mlGetSubscriber : mlGetSubscriberRequest){
            boolean notExist = true;
            for (SendFoxContact sendFoxContact: sfGetSubscribers){
                if(mlGetSubscriber.getEmail() != null && mlGetSubscriber.getEmail().equals(sendFoxContact.getEmail())){
                    notExist = false;
                    break;
                }
            }
            if(notExist){
                restService.updateSendFoxSubscribers(sendFoxSubscribersUrl, "authorization", sendFoxAuthorizationKey, mlGetSubscriber);
            }
        }
    }

    private void updateMailerLiteSubscribers(MSGetSubscriberContext msGetSubscriberRequest, MLGetSubscriberRequest[] mlGetSubscriberRequest){
        Subscribers[] msGetSubscribers = msGetSubscriberRequest.getSubscribers();
        for (Subscribers subscriber : msGetSubscribers){
            boolean exist = false;
            for (MLGetSubscriberRequest mlGetSubscriber: mlGetSubscriberRequest){
                if(subscriber.getEmail() != null && subscriber.getEmail().equals(mlGetSubscriber.getEmail())){
                    exist = true;
                    break;
                }
            }
            if(exist){
                restService.updateMailerLiteSubscribers(mailerliteSubscribersUrl, "X-MailerLite-ApiKey", sendMLAuthorizationKey, subscriber);
            }else {
                restService.createMailerLiteSubscribers(mailerliteSubscribersUrl + "/" + subscriber.getEmail(), "X-MailerLite-ApiKey", sendMLAuthorizationKey, subscriber);
            }
        }
    }


}
