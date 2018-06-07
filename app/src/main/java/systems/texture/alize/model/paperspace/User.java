package systems.texture.alize.model.paperspace;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class User implements Parcelable {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("isAdmin")
    @Expose
    private boolean isAdmin;
    @SerializedName("firstName")
    @Expose
    private Object firstName;
    @SerializedName("lastName")
    @Expose
    private Object lastName;
    @SerializedName("dtCreated")
    @Expose
    private String dtCreated;
    @SerializedName("dtModified")
    @Expose
    private String dtModified;
    @SerializedName("isDeleted")
    @Expose
    private boolean isDeleted;
    @SerializedName("isActive")
    @Expose
    private boolean isActive;
    @SerializedName("teamId")
    @Expose
    private Object teamId;
    @SerializedName("adUsername")
    @Expose
    private Object adUsername;
    @SerializedName("isQRCodeBasedMFAEnabled")
    @Expose
    private boolean isQRCodeBasedMFAEnabled;
    @SerializedName("isQRCodeBasedMFAConfirmed")
    @Expose
    private boolean isQRCodeBasedMFAConfirmed;
    @SerializedName("QRCodeBasedMFAEncryptedSeedSecret")
    @Expose
    private String qRCodeBasedMFAEncryptedSeedSecret;
    @SerializedName("dtLastLogin")
    @Expose
    private String dtLastLogin;
    @SerializedName("countLogins")
    @Expose
    private int countLogins;
    @SerializedName("maxMachines")
    @Expose
    private int maxMachines;
    @SerializedName("maxNotebooks")
    @Expose
    private int maxNotebooks;
    @SerializedName("maxRunningNotebooks")
    @Expose
    private int maxRunningNotebooks;
    @SerializedName("dtSignedUp")
    @Expose
    private String dtSignedUp;
    @SerializedName("isSignedUp")
    @Expose
    private boolean isSignedUp;
    @SerializedName("isConfirmed")
    @Expose
    private boolean isConfirmed;
    @SerializedName("dtConfirmed")
    @Expose
    private String dtConfirmed;
    @SerializedName("confirmCode")
    @Expose
    private String confirmCode;
    @SerializedName("isADAddComplete")
    @Expose
    private Object isADAddComplete;
    @SerializedName("isLinuxBeta")
    @Expose
    private boolean isLinuxBeta;
    @SerializedName("isM4000Window")
    @Expose
    private boolean isM4000Window;
    @SerializedName("isP5000Windows")
    @Expose
    private boolean isP5000Windows;
    @SerializedName("isP5000Linux")
    @Expose
    private boolean isP5000Linux;
    @SerializedName("isP6000Windows")
    @Expose
    private boolean isP6000Windows;
    @SerializedName("isP6000Linux")
    @Expose
    private boolean isP6000Linux;
    @SerializedName("isP4000Windows")
    @Expose
    private boolean isP4000Windows;
    @SerializedName("isP4000Linux")
    @Expose
    private boolean isP4000Linux;
    @SerializedName("isV100Windows")
    @Expose
    private boolean isV100Windows;
    @SerializedName("isV100Linux")
    @Expose
    private boolean isV100Linux;
    @SerializedName("isAPIBeta")
    @Expose
    private boolean isAPIBeta;
    @SerializedName("isH2OAvailable")
    @Expose
    private boolean isH2OAvailable;
    @SerializedName("dtDeleted")
    @Expose
    private Object dtDeleted;
    @SerializedName("handle")
    @Expose
    private String handle;
    @SerializedName("isAMSAvailable")
    @Expose
    private boolean isAMSAvailable;
    @SerializedName("isCPUAvailable")
    @Expose
    private boolean isCPUAvailable;
    @SerializedName("mlPro")
    @Expose
    private boolean mlPro;
    @SerializedName("maxJobs")
    @Expose
    private int maxJobs;
    @SerializedName("maxRunningJobs")
    @Expose
    private int maxRunningJobs;
    @SerializedName("id")
    @Expose
    private String id;
    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
                "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
            ;

    protected User(Parcel in) {
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.isAdmin = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.firstName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.lastName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.dtCreated = ((String) in.readValue((String.class.getClassLoader())));
        this.dtModified = ((String) in.readValue((String.class.getClassLoader())));
        this.isDeleted = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isActive = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.teamId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.adUsername = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isQRCodeBasedMFAEnabled = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isQRCodeBasedMFAConfirmed = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.qRCodeBasedMFAEncryptedSeedSecret = ((String) in.readValue((String.class.getClassLoader())));
        this.dtLastLogin = ((String) in.readValue((String.class.getClassLoader())));
        this.countLogins = ((int) in.readValue((int.class.getClassLoader())));
        this.maxMachines = ((int) in.readValue((int.class.getClassLoader())));
        this.maxNotebooks = ((int) in.readValue((int.class.getClassLoader())));
        this.maxRunningNotebooks = ((int) in.readValue((int.class.getClassLoader())));
        this.dtSignedUp = ((String) in.readValue((String.class.getClassLoader())));
        this.isSignedUp = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isConfirmed = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.dtConfirmed = ((String) in.readValue((String.class.getClassLoader())));
        this.confirmCode = ((String) in.readValue((String.class.getClassLoader())));
        this.isADAddComplete = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isLinuxBeta = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isM4000Window = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isP5000Windows = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isP5000Linux = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isP6000Windows = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isP6000Linux = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isP4000Windows = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isP4000Linux = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isV100Windows = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isV100Linux = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isAPIBeta = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isH2OAvailable = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.dtDeleted = ((Object) in.readValue((Object.class.getClassLoader())));
        this.handle = ((String) in.readValue((String.class.getClassLoader())));
        this.isAMSAvailable = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isCPUAvailable = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.mlPro = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.maxJobs = ((int) in.readValue((int.class.getClassLoader())));
        this.maxRunningJobs = ((int) in.readValue((int.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Object getFirstName() {
        return firstName;
    }

    public void setFirstName(Object firstName) {
        this.firstName = firstName;
    }

    public Object getLastName() {
        return lastName;
    }

    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    public String getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(String dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getDtModified() {
        return dtModified;
    }

    public void setDtModified(String dtModified) {
        this.dtModified = dtModified;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Object getTeamId() {
        return teamId;
    }

    public void setTeamId(Object teamId) {
        this.teamId = teamId;
    }

    public Object getAdUsername() {
        return adUsername;
    }

    public void setAdUsername(Object adUsername) {
        this.adUsername = adUsername;
    }

    public boolean isIsQRCodeBasedMFAEnabled() {
        return isQRCodeBasedMFAEnabled;
    }

    public void setIsQRCodeBasedMFAEnabled(boolean isQRCodeBasedMFAEnabled) {
        this.isQRCodeBasedMFAEnabled = isQRCodeBasedMFAEnabled;
    }

    public boolean isIsQRCodeBasedMFAConfirmed() {
        return isQRCodeBasedMFAConfirmed;
    }

    public void setIsQRCodeBasedMFAConfirmed(boolean isQRCodeBasedMFAConfirmed) {
        this.isQRCodeBasedMFAConfirmed = isQRCodeBasedMFAConfirmed;
    }

    public String getQRCodeBasedMFAEncryptedSeedSecret() {
        return qRCodeBasedMFAEncryptedSeedSecret;
    }

    public void setQRCodeBasedMFAEncryptedSeedSecret(String qRCodeBasedMFAEncryptedSeedSecret) {
        this.qRCodeBasedMFAEncryptedSeedSecret = qRCodeBasedMFAEncryptedSeedSecret;
    }

    public String getDtLastLogin() {
        return dtLastLogin;
    }

    public void setDtLastLogin(String dtLastLogin) {
        this.dtLastLogin = dtLastLogin;
    }

    public int getCountLogins() {
        return countLogins;
    }

    public void setCountLogins(int countLogins) {
        this.countLogins = countLogins;
    }

    public int getMaxMachines() {
        return maxMachines;
    }

    public void setMaxMachines(int maxMachines) {
        this.maxMachines = maxMachines;
    }

    public int getMaxNotebooks() {
        return maxNotebooks;
    }

    public void setMaxNotebooks(int maxNotebooks) {
        this.maxNotebooks = maxNotebooks;
    }

    public int getMaxRunningNotebooks() {
        return maxRunningNotebooks;
    }

    public void setMaxRunningNotebooks(int maxRunningNotebooks) {
        this.maxRunningNotebooks = maxRunningNotebooks;
    }

    public String getDtSignedUp() {
        return dtSignedUp;
    }

    public void setDtSignedUp(String dtSignedUp) {
        this.dtSignedUp = dtSignedUp;
    }

    public boolean isIsSignedUp() {
        return isSignedUp;
    }

    public void setIsSignedUp(boolean isSignedUp) {
        this.isSignedUp = isSignedUp;
    }

    public boolean isIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public String getDtConfirmed() {
        return dtConfirmed;
    }

    public void setDtConfirmed(String dtConfirmed) {
        this.dtConfirmed = dtConfirmed;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    public Object getIsADAddComplete() {
        return isADAddComplete;
    }

    public void setIsADAddComplete(Object isADAddComplete) {
        this.isADAddComplete = isADAddComplete;
    }

    public boolean isIsLinuxBeta() {
        return isLinuxBeta;
    }

    public void setIsLinuxBeta(boolean isLinuxBeta) {
        this.isLinuxBeta = isLinuxBeta;
    }

    public boolean isIsM4000Window() {
        return isM4000Window;
    }

    public void setIsM4000Window(boolean isM4000Window) {
        this.isM4000Window = isM4000Window;
    }

    public boolean isIsP5000Windows() {
        return isP5000Windows;
    }

    public void setIsP5000Windows(boolean isP5000Windows) {
        this.isP5000Windows = isP5000Windows;
    }

    public boolean isIsP5000Linux() {
        return isP5000Linux;
    }

    public void setIsP5000Linux(boolean isP5000Linux) {
        this.isP5000Linux = isP5000Linux;
    }

    public boolean isIsP6000Windows() {
        return isP6000Windows;
    }

    public void setIsP6000Windows(boolean isP6000Windows) {
        this.isP6000Windows = isP6000Windows;
    }

    public boolean isIsP6000Linux() {
        return isP6000Linux;
    }

    public void setIsP6000Linux(boolean isP6000Linux) {
        this.isP6000Linux = isP6000Linux;
    }

    public boolean isIsP4000Windows() {
        return isP4000Windows;
    }

    public void setIsP4000Windows(boolean isP4000Windows) {
        this.isP4000Windows = isP4000Windows;
    }

    public boolean isIsP4000Linux() {
        return isP4000Linux;
    }

    public void setIsP4000Linux(boolean isP4000Linux) {
        this.isP4000Linux = isP4000Linux;
    }

    public boolean isIsV100Windows() {
        return isV100Windows;
    }

    public void setIsV100Windows(boolean isV100Windows) {
        this.isV100Windows = isV100Windows;
    }

    public boolean isIsV100Linux() {
        return isV100Linux;
    }

    public void setIsV100Linux(boolean isV100Linux) {
        this.isV100Linux = isV100Linux;
    }

    public boolean isIsAPIBeta() {
        return isAPIBeta;
    }

    public void setIsAPIBeta(boolean isAPIBeta) {
        this.isAPIBeta = isAPIBeta;
    }

    public boolean isIsH2OAvailable() {
        return isH2OAvailable;
    }

    public void setIsH2OAvailable(boolean isH2OAvailable) {
        this.isH2OAvailable = isH2OAvailable;
    }

    public Object getDtDeleted() {
        return dtDeleted;
    }

    public void setDtDeleted(Object dtDeleted) {
        this.dtDeleted = dtDeleted;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public boolean isIsAMSAvailable() {
        return isAMSAvailable;
    }

    public void setIsAMSAvailable(boolean isAMSAvailable) {
        this.isAMSAvailable = isAMSAvailable;
    }

    public boolean isIsCPUAvailable() {
        return isCPUAvailable;
    }

    public void setIsCPUAvailable(boolean isCPUAvailable) {
        this.isCPUAvailable = isCPUAvailable;
    }

    public boolean isMlPro() {
        return mlPro;
    }

    public void setMlPro(boolean mlPro) {
        this.mlPro = mlPro;
    }

    public int getMaxJobs() {
        return maxJobs;
    }

    public void setMaxJobs(int maxJobs) {
        this.maxJobs = maxJobs;
    }

    public int getMaxRunningJobs() {
        return maxRunningJobs;
    }

    public void setMaxRunningJobs(int maxRunningJobs) {
        this.maxRunningJobs = maxRunningJobs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("email", email).append("isAdmin", isAdmin).append("firstName", firstName).append("lastName", lastName).append("dtCreated", dtCreated).append("dtModified", dtModified).append("isDeleted", isDeleted).append("isActive", isActive).append("teamId", teamId).append("adUsername", adUsername).append("isQRCodeBasedMFAEnabled", isQRCodeBasedMFAEnabled).append("isQRCodeBasedMFAConfirmed", isQRCodeBasedMFAConfirmed).append("qRCodeBasedMFAEncryptedSeedSecret", qRCodeBasedMFAEncryptedSeedSecret).append("dtLastLogin", dtLastLogin).append("countLogins", countLogins).append("maxMachines", maxMachines).append("maxNotebooks", maxNotebooks).append("maxRunningNotebooks", maxRunningNotebooks).append("dtSignedUp", dtSignedUp).append("isSignedUp", isSignedUp).append("isConfirmed", isConfirmed).append("dtConfirmed", dtConfirmed).append("confirmCode", confirmCode).append("isADAddComplete", isADAddComplete).append("isLinuxBeta", isLinuxBeta).append("isM4000Window", isM4000Window).append("isP5000Windows", isP5000Windows).append("isP5000Linux", isP5000Linux).append("isP6000Windows", isP6000Windows).append("isP6000Linux", isP6000Linux).append("isP4000Windows", isP4000Windows).append("isP4000Linux", isP4000Linux).append("isV100Windows", isV100Windows).append("isV100Linux", isV100Linux).append("isAPIBeta", isAPIBeta).append("isH2OAvailable", isH2OAvailable).append("dtDeleted", dtDeleted).append("handle", handle).append("isAMSAvailable", isAMSAvailable).append("isCPUAvailable", isCPUAvailable).append("mlPro", mlPro).append("maxJobs", maxJobs).append("maxRunningJobs", maxRunningJobs).append("id", id).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(handle).append(isConfirmed).append(maxJobs).append(isQRCodeBasedMFAConfirmed).append(confirmCode).append(countLogins).append(isADAddComplete).append(adUsername).append(teamId).append(id).append(isP4000Windows).append(isP6000Windows).append(isLinuxBeta).append(isAPIBeta).append(isH2OAvailable).append(dtModified).append(isM4000Window).append(maxRunningJobs).append(mlPro).append(isV100Linux).append(firstName).append(dtLastLogin).append(isP4000Linux).append(isQRCodeBasedMFAEnabled).append(lastName).append(dtConfirmed).append(isAMSAvailable).append(isSignedUp).append(isP5000Windows).append(maxRunningNotebooks).append(dtSignedUp).append(isDeleted).append(dtDeleted).append(qRCodeBasedMFAEncryptedSeedSecret).append(maxMachines).append(isActive).append(isV100Windows).append(isP5000Linux).append(email).append(maxNotebooks).append(isAdmin).append(isP6000Linux).append(isCPUAvailable).append(dtCreated).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User rhs = ((User) other);
        return new EqualsBuilder().append(handle, rhs.handle).append(isConfirmed, rhs.isConfirmed).append(maxJobs, rhs.maxJobs).append(isQRCodeBasedMFAConfirmed, rhs.isQRCodeBasedMFAConfirmed).append(confirmCode, rhs.confirmCode).append(countLogins, rhs.countLogins).append(isADAddComplete, rhs.isADAddComplete).append(adUsername, rhs.adUsername).append(teamId, rhs.teamId).append(id, rhs.id).append(isP4000Windows, rhs.isP4000Windows).append(isP6000Windows, rhs.isP6000Windows).append(isLinuxBeta, rhs.isLinuxBeta).append(isAPIBeta, rhs.isAPIBeta).append(isH2OAvailable, rhs.isH2OAvailable).append(dtModified, rhs.dtModified).append(isM4000Window, rhs.isM4000Window).append(maxRunningJobs, rhs.maxRunningJobs).append(mlPro, rhs.mlPro).append(isV100Linux, rhs.isV100Linux).append(firstName, rhs.firstName).append(dtLastLogin, rhs.dtLastLogin).append(isP4000Linux, rhs.isP4000Linux).append(isQRCodeBasedMFAEnabled, rhs.isQRCodeBasedMFAEnabled).append(lastName, rhs.lastName).append(dtConfirmed, rhs.dtConfirmed).append(isAMSAvailable, rhs.isAMSAvailable).append(isSignedUp, rhs.isSignedUp).append(isP5000Windows, rhs.isP5000Windows).append(maxRunningNotebooks, rhs.maxRunningNotebooks).append(dtSignedUp, rhs.dtSignedUp).append(isDeleted, rhs.isDeleted).append(dtDeleted, rhs.dtDeleted).append(qRCodeBasedMFAEncryptedSeedSecret, rhs.qRCodeBasedMFAEncryptedSeedSecret).append(maxMachines, rhs.maxMachines).append(isActive, rhs.isActive).append(isV100Windows, rhs.isV100Windows).append(isP5000Linux, rhs.isP5000Linux).append(email, rhs.email).append(maxNotebooks, rhs.maxNotebooks).append(isAdmin, rhs.isAdmin).append(isP6000Linux, rhs.isP6000Linux).append(isCPUAvailable, rhs.isCPUAvailable).append(dtCreated, rhs.dtCreated).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(email);
        dest.writeValue(isAdmin);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(dtCreated);
        dest.writeValue(dtModified);
        dest.writeValue(isDeleted);
        dest.writeValue(isActive);
        dest.writeValue(teamId);
        dest.writeValue(adUsername);
        dest.writeValue(isQRCodeBasedMFAEnabled);
        dest.writeValue(isQRCodeBasedMFAConfirmed);
        dest.writeValue(qRCodeBasedMFAEncryptedSeedSecret);
        dest.writeValue(dtLastLogin);
        dest.writeValue(countLogins);
        dest.writeValue(maxMachines);
        dest.writeValue(maxNotebooks);
        dest.writeValue(maxRunningNotebooks);
        dest.writeValue(dtSignedUp);
        dest.writeValue(isSignedUp);
        dest.writeValue(isConfirmed);
        dest.writeValue(dtConfirmed);
        dest.writeValue(confirmCode);
        dest.writeValue(isADAddComplete);
        dest.writeValue(isLinuxBeta);
        dest.writeValue(isM4000Window);
        dest.writeValue(isP5000Windows);
        dest.writeValue(isP5000Linux);
        dest.writeValue(isP6000Windows);
        dest.writeValue(isP6000Linux);
        dest.writeValue(isP4000Windows);
        dest.writeValue(isP4000Linux);
        dest.writeValue(isV100Windows);
        dest.writeValue(isV100Linux);
        dest.writeValue(isAPIBeta);
        dest.writeValue(isH2OAvailable);
        dest.writeValue(dtDeleted);
        dest.writeValue(handle);
        dest.writeValue(isAMSAvailable);
        dest.writeValue(isCPUAvailable);
        dest.writeValue(mlPro);
        dest.writeValue(maxJobs);
        dest.writeValue(maxRunningJobs);
        dest.writeValue(id);
    }

    public int describeContents() {
        return 0;
    }

}