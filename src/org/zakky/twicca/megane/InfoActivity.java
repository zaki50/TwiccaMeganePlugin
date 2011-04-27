/*
 * Copyright 2011 YAMAZAKI Makoto<makoto1975@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zakky.twicca.megane;

import android.app.Activity;
import android.content.Intent;

public class InfoActivity extends Activity {
    
    @Override
    protected void onStart() {
        super.onStart();

        final Intent intent = getIntent();
        if (intent == null) {
            setResult(Activity.RESULT_CANCELED);
            finish();
        }
        final String prefix = toNonNull(intent.getStringExtra("prefix"));
        final String user_input = toNonNull(intent.getStringExtra("user_input"));
        final String suffix = toNonNull(intent.getStringExtra("suffix"));

        final String result = prefix + '眼' + user_input + '鏡' + suffix;

        final Intent resultIntent = new Intent();
        resultIntent.putExtra(Intent.EXTRA_TEXT, result);

        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private static String toNonNull(String nullable) {
        if (nullable == null) {
            return "";
        }
        return nullable;
    }

}
