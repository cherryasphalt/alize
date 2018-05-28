package systems.texture.alize.model.paperspace;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Login implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ttl")
    @Expose
    private int ttl;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("userId")
    @Expose
    private int userId;
    @SerializedName("user")
    @Expose
    private User user;
    public final static Parcelable.Creator<Login> CREATOR = new Creator<Login>() {
        @SuppressWarnings({"unchecked"})
        public Login createFromParcel(Parcel in) {
            return new Login(in);
        }

        public Login[] newArray(int size) {
            return (new Login[size]);
        }

    };

    protected Login(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.ttl = ((int) in.readValue((int.class.getClassLoader())));
        this.created = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((int) in.readValue((int.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
    }

    public Login() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("ttl", ttl).append("created", created).append("userId", userId).append("user", user).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(created).append(userId).append(ttl).append(user).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Login)) {
            return false;
        }
        Login rhs = ((Login) other);
        return new EqualsBuilder().append(id, rhs.id).append(created, rhs.created).append(userId, rhs.userId).append(ttl, rhs.ttl).append(user, rhs.user).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(ttl);
        dest.writeValue(created);
        dest.writeValue(userId);
        dest.writeValue(user);
    }

    public int describeContents() {
        return 0;
    }

}