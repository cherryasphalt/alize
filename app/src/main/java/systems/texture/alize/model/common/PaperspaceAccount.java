package systems.texture.alize.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import systems.texture.alize.model.paperspace.User;

public class PaperspaceAccount implements Parcelable {
    String apiKey;
    User user;

    public PaperspaceAccount(@NonNull String apiKey, @NonNull User user) {
        this.apiKey = apiKey;
        this.user = user;
    }

    protected PaperspaceAccount(Parcel in) {
        this.apiKey = ((String) in.readValue(String.class.getClassLoader()));
        this.user = ((User) in.readValue(User.class.getClassLoader()));
    }

    public static final Creator<PaperspaceAccount> CREATOR = new Creator<PaperspaceAccount>() {
        @Override
        public PaperspaceAccount createFromParcel(Parcel in) {
            return new PaperspaceAccount(in);
        }

        @Override
        public PaperspaceAccount[] newArray(int size) {
            return new PaperspaceAccount[size];
        }
    };

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("apiKey", apiKey).append("user", user).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(apiKey).append(user).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PaperspaceAccount)) {
            return false;
        }
        PaperspaceAccount rhs = ((PaperspaceAccount) other);
        return new EqualsBuilder().append(apiKey, rhs.apiKey).append(user, rhs.user).isEquals();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(apiKey);
        dest.writeValue(user);
    }
}
