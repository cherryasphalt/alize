package systems.texture.alize.model.paperspace;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Machine implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("os")
    @Expose
    private String os;
    @SerializedName("ram")
    @Expose
    private String ram;
    @SerializedName("cpus")
    @Expose
    private int cpus;
    @SerializedName("gpu")
    @Expose
    private String gpu;
    @SerializedName("storageTotal")
    @Expose
    private String storageTotal;
    @SerializedName("storageUsed")
    @Expose
    private String storageUsed;
    @SerializedName("usageRate")
    @Expose
    private String usageRate;
    @SerializedName("shutdownTimeoutInHours")
    @Expose
    private int shutdownTimeoutInHours;
    @SerializedName("shutdownTimeoutForces")
    @Expose
    private boolean shutdownTimeoutForces;
    @SerializedName("performAutoSnapshot")
    @Expose
    private boolean performAutoSnapshot;
    @SerializedName("autoSnapshotFrequency")
    @Expose
    private Object autoSnapshotFrequency;
    @SerializedName("autoSnapshotSaveCount")
    @Expose
    private Object autoSnapshotSaveCount;
    @SerializedName("dynamicPublicIp")
    @Expose
    private boolean dynamicPublicIp;
    @SerializedName("agentType")
    @Expose
    private String agentType;
    @SerializedName("dtCreated")
    @Expose
    private String dtCreated;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("updatesPending")
    @Expose
    private boolean updatesPending;
    @SerializedName("networkId")
    @Expose
    private String networkId;
    @SerializedName("privateIpAddress")
    @Expose
    private String privateIpAddress;
    @SerializedName("publicIpAddress")
    @Expose
    private String publicIpAddress;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("teamId")
    @Expose
    private Object teamId;
    @SerializedName("scriptId")
    @Expose
    private Object scriptId;
    @SerializedName("dtLastRun")
    @Expose
    private Object dtLastRun;
    public final static Parcelable.Creator<Machine> CREATOR = new Creator<Machine>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Machine createFromParcel(Parcel in) {
            return new Machine(in);
        }

        public Machine[] newArray(int size) {
            return (new Machine[size]);
        }

    }
            ;

    protected Machine(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.os = ((String) in.readValue((String.class.getClassLoader())));
        this.ram = ((String) in.readValue((String.class.getClassLoader())));
        this.cpus = ((int) in.readValue((int.class.getClassLoader())));
        this.gpu = ((String) in.readValue((String.class.getClassLoader())));
        this.storageTotal = ((String) in.readValue((String.class.getClassLoader())));
        this.storageUsed = ((String) in.readValue((String.class.getClassLoader())));
        this.usageRate = ((String) in.readValue((String.class.getClassLoader())));
        this.shutdownTimeoutInHours = ((int) in.readValue((int.class.getClassLoader())));
        this.shutdownTimeoutForces = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.performAutoSnapshot = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.autoSnapshotFrequency = ((Object) in.readValue((Object.class.getClassLoader())));
        this.autoSnapshotSaveCount = ((Object) in.readValue((Object.class.getClassLoader())));
        this.dynamicPublicIp = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.agentType = ((String) in.readValue((String.class.getClassLoader())));
        this.dtCreated = ((String) in.readValue((String.class.getClassLoader())));
        this.state = ((String) in.readValue((String.class.getClassLoader())));
        this.updatesPending = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.networkId = ((String) in.readValue((String.class.getClassLoader())));
        this.privateIpAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.publicIpAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.region = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.teamId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.scriptId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.dtLastRun = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Machine() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getCpus() {
        return cpus;
    }

    public void setCpus(int cpus) {
        this.cpus = cpus;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getStorageTotal() {
        return storageTotal;
    }

    public void setStorageTotal(String storageTotal) {
        this.storageTotal = storageTotal;
    }

    public String getStorageUsed() {
        return storageUsed;
    }

    public void setStorageUsed(String storageUsed) {
        this.storageUsed = storageUsed;
    }

    public String getUsageRate() {
        return usageRate;
    }

    public void setUsageRate(String usageRate) {
        this.usageRate = usageRate;
    }

    public int getShutdownTimeoutInHours() {
        return shutdownTimeoutInHours;
    }

    public void setShutdownTimeoutInHours(int shutdownTimeoutInHours) {
        this.shutdownTimeoutInHours = shutdownTimeoutInHours;
    }

    public boolean isShutdownTimeoutForces() {
        return shutdownTimeoutForces;
    }

    public void setShutdownTimeoutForces(boolean shutdownTimeoutForces) {
        this.shutdownTimeoutForces = shutdownTimeoutForces;
    }

    public boolean isPerformAutoSnapshot() {
        return performAutoSnapshot;
    }

    public void setPerformAutoSnapshot(boolean performAutoSnapshot) {
        this.performAutoSnapshot = performAutoSnapshot;
    }

    public Object getAutoSnapshotFrequency() {
        return autoSnapshotFrequency;
    }

    public void setAutoSnapshotFrequency(Object autoSnapshotFrequency) {
        this.autoSnapshotFrequency = autoSnapshotFrequency;
    }

    public Object getAutoSnapshotSaveCount() {
        return autoSnapshotSaveCount;
    }

    public void setAutoSnapshotSaveCount(Object autoSnapshotSaveCount) {
        this.autoSnapshotSaveCount = autoSnapshotSaveCount;
    }

    public boolean isDynamicPublicIp() {
        return dynamicPublicIp;
    }

    public void setDynamicPublicIp(boolean dynamicPublicIp) {
        this.dynamicPublicIp = dynamicPublicIp;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(String dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isUpdatesPending() {
        return updatesPending;
    }

    public void setUpdatesPending(boolean updatesPending) {
        this.updatesPending = updatesPending;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getPrivateIpAddress() {
        return privateIpAddress;
    }

    public void setPrivateIpAddress(String privateIpAddress) {
        this.privateIpAddress = privateIpAddress;
    }

    public String getPublicIpAddress() {
        return publicIpAddress;
    }

    public void setPublicIpAddress(String publicIpAddress) {
        this.publicIpAddress = publicIpAddress;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getTeamId() {
        return teamId;
    }

    public void setTeamId(Object teamId) {
        this.teamId = teamId;
    }

    public Object getScriptId() {
        return scriptId;
    }

    public void setScriptId(Object scriptId) {
        this.scriptId = scriptId;
    }

    public Object getDtLastRun() {
        return dtLastRun;
    }

    public void setDtLastRun(Object dtLastRun) {
        this.dtLastRun = dtLastRun;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("os", os).append("ram", ram).append("cpus", cpus).append("gpu", gpu).append("storageTotal", storageTotal).append("storageUsed", storageUsed).append("usageRate", usageRate).append("shutdownTimeoutInHours", shutdownTimeoutInHours).append("shutdownTimeoutForces", shutdownTimeoutForces).append("performAutoSnapshot", performAutoSnapshot).append("autoSnapshotFrequency", autoSnapshotFrequency).append("autoSnapshotSaveCount", autoSnapshotSaveCount).append("dynamicPublicIp", dynamicPublicIp).append("agentType", agentType).append("dtCreated", dtCreated).append("state", state).append("updatesPending", updatesPending).append("networkId", networkId).append("privateIpAddress", privateIpAddress).append("publicIpAddress", publicIpAddress).append("region", region).append("userId", userId).append("teamId", teamId).append("scriptId", scriptId).append("dtLastRun", dtLastRun).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(region).append(shutdownTimeoutInHours).append(autoSnapshotSaveCount).append(networkId).append(state).append(teamId).append(storageUsed).append(shutdownTimeoutForces).append(privateIpAddress).append(id).append(cpus).append(userId).append(name).append(publicIpAddress).append(usageRate).append(autoSnapshotFrequency).append(scriptId).append(performAutoSnapshot).append(gpu).append(os).append(storageTotal).append(updatesPending).append(dtLastRun).append(ram).append(dynamicPublicIp).append(agentType).append(dtCreated).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Machine)) {
            return false;
        }
        Machine rhs = ((Machine) other);
        return new EqualsBuilder().append(region, rhs.region).append(shutdownTimeoutInHours, rhs.shutdownTimeoutInHours).append(autoSnapshotSaveCount, rhs.autoSnapshotSaveCount).append(networkId, rhs.networkId).append(state, rhs.state).append(teamId, rhs.teamId).append(storageUsed, rhs.storageUsed).append(shutdownTimeoutForces, rhs.shutdownTimeoutForces).append(privateIpAddress, rhs.privateIpAddress).append(id, rhs.id).append(cpus, rhs.cpus).append(userId, rhs.userId).append(name, rhs.name).append(publicIpAddress, rhs.publicIpAddress).append(usageRate, rhs.usageRate).append(autoSnapshotFrequency, rhs.autoSnapshotFrequency).append(scriptId, rhs.scriptId).append(performAutoSnapshot, rhs.performAutoSnapshot).append(gpu, rhs.gpu).append(os, rhs.os).append(storageTotal, rhs.storageTotal).append(updatesPending, rhs.updatesPending).append(dtLastRun, rhs.dtLastRun).append(ram, rhs.ram).append(dynamicPublicIp, rhs.dynamicPublicIp).append(agentType, rhs.agentType).append(dtCreated, rhs.dtCreated).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(os);
        dest.writeValue(ram);
        dest.writeValue(cpus);
        dest.writeValue(gpu);
        dest.writeValue(storageTotal);
        dest.writeValue(storageUsed);
        dest.writeValue(usageRate);
        dest.writeValue(shutdownTimeoutInHours);
        dest.writeValue(shutdownTimeoutForces);
        dest.writeValue(performAutoSnapshot);
        dest.writeValue(autoSnapshotFrequency);
        dest.writeValue(autoSnapshotSaveCount);
        dest.writeValue(dynamicPublicIp);
        dest.writeValue(agentType);
        dest.writeValue(dtCreated);
        dest.writeValue(state);
        dest.writeValue(updatesPending);
        dest.writeValue(networkId);
        dest.writeValue(privateIpAddress);
        dest.writeValue(publicIpAddress);
        dest.writeValue(region);
        dest.writeValue(userId);
        dest.writeValue(teamId);
        dest.writeValue(scriptId);
        dest.writeValue(dtLastRun);
    }

    public int describeContents() {
        return 0;
    }

}