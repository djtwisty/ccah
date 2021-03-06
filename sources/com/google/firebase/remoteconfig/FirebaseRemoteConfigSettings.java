package com.google.firebase.remoteconfig;

public class FirebaseRemoteConfigSettings {
    private final boolean zzap;

    public static class Builder {
        private boolean zzap = false;

        public Builder setDeveloperModeEnabled(boolean z) {
            this.zzap = z;
            return this;
        }

        public FirebaseRemoteConfigSettings build() {
            return new FirebaseRemoteConfigSettings();
        }
    }

    private FirebaseRemoteConfigSettings(Builder builder) {
        this.zzap = builder.zzap;
    }

    public boolean isDeveloperModeEnabled() {
        return this.zzap;
    }
}
