package com.manywho.services.cf.deploy;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = DeployParameter.NAME)
public class DeployParameter implements Type {
    public final static String NAME = "Deploy Parameter";

    public DeployParameter() {
    }

    @Type.Identifier
    @Type.Property(name = "Name", contentType = ContentType.String)
    private String name;

    @Type.Property(name = "Value", contentType = ContentType.String)
    private String value;

}
