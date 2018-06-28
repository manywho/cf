package com.manywho.services.cf.deploy;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;

@Action.Metadata(name = "Deploy Configuration", summary = "Deploy Configuration", uri = "deploy")
public class DeployInput {
    public static class Input {
        @Action.Input(name = "Deploy", contentType = ContentType.Object, required = true)
        private Deploy deploy;

        public Deploy getDeploy() {
            return deploy;
        }
    }

    public static class Output {
        @Action.Output(name = "Status", contentType = ContentType.Boolean)
        private Boolean status;

        public Output(Boolean status) {
            this.status = status;
        }
    }
}
