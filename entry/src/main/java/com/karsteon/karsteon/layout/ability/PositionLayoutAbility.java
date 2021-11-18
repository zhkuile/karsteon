package com.karsteon.karsteon.layout.ability;

import com.karsteon.karsteon.ResourceTable;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;

public class PositionLayoutAbility extends Ability {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_position_layout);

        Button button1 = (Button)findComponentById(ResourceTable.Id_button1);
        if (button1 !=null) {
            button1.setPosition(100,200);

        }

        Button button2 = (Button)findComponentById(ResourceTable.Id_button2);
        if(button2 !=null) {
            button2.setContentPositionX(500);
            button2.setContentPositionY(1200);
            button2.setWidth(300);
            button2.setHeight(600);
        }
        Button button3 = (Button)findComponentById(ResourceTable.Id_button3);
        if(button3 != null) {
            button3.setContentPosition(600,1200);

        }

    }
}
