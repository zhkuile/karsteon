package com.karsteon.karsteon.layout.ability;

import com.karsteon.karsteon.ResourceTable;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;


public class TestAbility extends Ability {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_directional_layout_demo);
    }
}
