package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzr implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ FirebaseUser zzhk;

    zzr(FirebaseUser firebaseUser) {
        this.zzhk = firebaseUser;
    }

    public final /* synthetic */ Object then(Task task) {
        return FirebaseAuth.getInstance(this.zzhk.zzcc()).zza(null, ((GetTokenResult) task.getResult()).getToken());
    }
}
