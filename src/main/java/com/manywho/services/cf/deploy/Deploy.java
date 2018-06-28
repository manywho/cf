package com.manywho.services.cf.deploy;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

import java.util.List;

@Type.Element(name = Deploy.NAME)
public class Deploy implements Type {
    public final static String NAME = "Deploy";

    public Deploy() {
    }

    @Type.Identifier
    @Type.Property(name = "ID", contentType = ContentType.String)
    private String id;

    @Type.Property(name = "Host", contentType = ContentType.String)
    private String host;

    @Type.Property(name = "Organization", contentType = ContentType.String)
    private String organization;

    @Type.Property(name = "Space", contentType = ContentType.String)
    private String space;

    @Type.Property(name = "Username", contentType = ContentType.String)
    private String username;

    @Type.Property(name = "Password", contentType = ContentType.Password)
    private String password;

    @Type.Property(name = "Build Pack Source", contentType = ContentType.String)
    private String buildpackSource;

    @Type.Property(name = "Code Source", contentType = ContentType.String)
    private String codeSource;

    @Type.Property(name = "Parameters", contentType = ContentType.List)
    private List<DeployParameter> parameters;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBuildpackSource() {
        return buildpackSource;
    }

    public void setBuildpackSource(String buildpackSource) {
        this.buildpackSource = buildpackSource;
    }

    public String getCodeSource() {
        return codeSource;
    }

    public void setCodeSource(String codeSource) {
        this.codeSource = codeSource;
    }

    public List<DeployParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<DeployParameter> parameters) {
        this.parameters = parameters;
    }
}
