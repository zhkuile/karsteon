package com.karsteon.karsteon;

import com.karsteon.karsteon.slice.AbilityAndSliceSlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;


public class TargetAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_target_layout);
        super.setMainRoute(AbilityAndSliceSlice.class.getName());

        Text text = (Text)findComponentById(ResourceTable.Id_text);
        if(text != null) {
            String name = intent.getStringParam("name");
            int age = intent.getIntParam("age", -1);
            int[] data = intent.getIntArrayParam("data");
            String dataStr = "";
            for(int value : data) {
                dataStr += value + " ";
            }
            text.setMultipleLine(true);
            text.setText(String.format("name:%s\r\nage:%d\r\ndata:%s", name,age,dataStr));
        }

        Button buttonClose = (Button)findComponentById(ResourceTable.Id_button_close);
        if(buttonClose != null) {
            buttonClose.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    Intent resultIntent = new Intent();

                    resultIntent.setParam("result", "OK");

                    setResult(100, resultIntent);
                    terminateAbility();
                }
            });
        }


    }
}
