package com.manywho.services.cf.deploy;

import com.google.inject.Inject;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;
import com.manywho.sdk.services.providers.AuthenticatedWhoProvider;
import com.manywho.services.cf.ServiceConfiguration;
import org.cloudfoundry.operations.DefaultCloudFoundryOperations;
import org.cloudfoundry.operations.applications.PushApplicationRequest;
import org.cloudfoundry.operations.buildpacks.Buildpacks;
import org.cloudfoundry.reactor.DefaultConnectionContext;
import org.cloudfoundry.reactor.doppler.ReactorDopplerClient;
import org.cloudfoundry.reactor.tokenprovider.PasswordGrantTokenProvider;

public class DeployCommand implements ActionCommand<ServiceConfiguration, DeployInput, DeployInput.Input, DeployInput.Output> {
    private AuthenticatedWhoProvider authenticatedWhoProvider;

    @Inject
    public DeployCommand(AuthenticatedWhoProvider authenticatedWhoProvider) {
        this.authenticatedWhoProvider = authenticatedWhoProvider;
    }

    @Override
    public ActionResponse<DeployInput.Output> execute(ServiceConfiguration serviceConfiguration, ServiceRequest serviceRequest, DeployInput.Input input) {
        Boolean status = false;

        DefaultCloudFoundryOperations cloudFoundryOperations = DefaultCloudFoundryOperations.builder()
//                .cloudFoundryClient(cloudFoundryClient)
                .dopplerClient(client(input.getDeploy().getUsername(), input.getDeploy().getPassword(), input.getDeploy().getHost()))
//                .uaaClient(uaaClient)
                .organization(input.getDeploy().getOrganization())
                .space(input.getDeploy().getSpace())
                .build();

//        PushApplicationRequest applicationRequest = PushApplicationRequest.Builder();
//        cloudFoundryOperations.applications().push()

        Buildpacks buildpacks = cloudFoundryOperations.buildpacks();


        DeployInput.Output output = new DeployInput.Output(status);
        return new ActionResponse<>(output);
    }

    private ReactorDopplerClient client(String username, String password, String apiHost) {

        return ReactorDopplerClient.builder()
                .connectionContext(DefaultConnectionContext.builder().apiHost(apiHost).build())
                .tokenProvider(PasswordGrantTokenProvider.builder()
                        .password(password)
                        .username(username)
                        .build())
                .build();
    }
}
