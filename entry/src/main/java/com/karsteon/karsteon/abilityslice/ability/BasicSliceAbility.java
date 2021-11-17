package com.karsteon.karsteon.abilityslice.ability;

import com.karsteon.karsteon.abilityslice.slice.BasicSlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class BasicSliceAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        //导航到basicslice
        super.setMainRoute(BasicSlice.class.getName());
    }
}
