package qa.guru.kaspresso

import android.Manifest
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.components.alluresupport.withAllureSupport
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class IncrementButtonTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport (  )
) {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    @Test
    fun incrementButtonShouldIncreaseValue() = run {
        step("Launch the app") {
            MainScreen {
                incrementButton.isDisplayed()
                incrementButton {
                    repeat(5) {
                        click()
                    }
                }
                valueText.hasText("Count: 5")
            }
        }
    }

}