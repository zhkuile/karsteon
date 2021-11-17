package com.karsteon.karsteon.abilityslice.slice;

import com.karsteon.karsteon.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class ResultSlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_result_slice_layout);
        Text text = (Text) findComponentById(ResourceTable.Id_text);
        if (text !=null) {
            // 取出basicslice 传递的数据并显示
            String data = intent.getStringParam("data");
            text.setText(data);
        }

        Button button = (Button)findComponentById(ResourceTable.Id_button_close_slice);
        if (button !=null) {
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    Intent intent1 = new Intent();
                    // 回传结果数据
                    intent1.setParam("data","l love you");
                    setResult(intent1);
                    terminate();
                }
            });
        }
    }
}
