package cafe.adriel.voyager.navigator.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalArkUIViewController
import cafe.adriel.voyager.core.annotation.InternalVoyagerApi

@InternalVoyagerApi
@Composable
public actual fun BackHandler(enabled: Boolean, onBack: () -> Unit) {
    val onBackPressedDispatcher = LocalArkUIViewController.current.onBackPressedDispatcher
    val enableState by rememberUpdatedState(enabled)
    DisposableEffect(Unit) {
        val cancel = onBackPressedDispatcher.addOnBackPressedCallback {
            if (enableState) {
                onBack()
                true
            } else {
                false
            }
        }
        onDispose(cancel)
    }
}
