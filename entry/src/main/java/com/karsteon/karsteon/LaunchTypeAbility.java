package com.karsteon.karsteon;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class LaunchTypeAbility extends Ability {
    private static int count = 0;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_launch_type_layout);
        count ++;
        Text text = (Text) findComponentById(ResourceTable.Layout_launch_type_layout);
        if (text !=null) {
            text.setText(String.format("count: %s",count));
        }

        Button button = (Button) findComponentById(ResourceTable.Id_button_start_ability);

        if (button !=null) {
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    Intent intent = new Intent();
                    intent.setAction("action.harmonyos.demo.ability.testlaunchtype");
                    startAbility(intent);
                }
            });
        }
    }
}
