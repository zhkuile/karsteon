package com.karsteon.karsteon.abilityslice.slice;

import com.karsteon.karsteon.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class BasicSlice extends AbilitySlice {
    private Text textResult;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_basic_slice_layout);
        textResult = (Text) findComponentById(ResourceTable.Id_text_result);
        if (textResult !=null) {

        }

        Button button = (Button) findComponentById(ResourceTable.Id_button_present_slice);
        if (button !=null) {
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    Intent intent1 = new Intent();
                    // 设置数据，这个是要传给resultslice的数据
                    intent1.setParam("data","hello zk");
                    // 导航到resultslice,并携带数据，设置请求码
                    presentForResult(new ResultSlice(),intent1,200);
                }
            });
        }
    }

    /**
     * 获取返回的数据
     * @param requestCode
     * @param resultIntent
     */
    @Override
    protected void onResult(int requestCode, Intent resultIntent) {
        super.onResult(requestCode, resultIntent);
        switch (requestCode) {
            case 100:
                textResult.setText(resultIntent.getStringParam("data"));
            default:
                textResult.setText("l dont know");
        }
    }
}
