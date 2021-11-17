package com.karsteon.karsteon;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class TestLaunchTypeAbility extends Ability {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_launch_type_layout);

        Button buttonStartAbility = (Button)findComponentById(ResourceTable.Id_button_start_ability);
        if(buttonStartAbility != null) {
            buttonStartAbility.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    Intent intent = new Intent();
                    intent.setAction("action.harmonyos.demo.ability.launchtype");
                    startAbility(intent);
                }
            });
        }
    }
}
