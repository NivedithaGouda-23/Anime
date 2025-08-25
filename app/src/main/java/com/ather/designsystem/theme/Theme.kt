@Composable
fun RideStatsTheme(darkTheme: Boolean = true, content: @Composable () -> Unit) {
    val colorScheme = rideStatsThemeColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // For dark theme, use a dark color for status bar background
            window.statusBarColor = if (darkTheme) {
                AtherColorTokens.Surface.Default.primaryDark.toArgb()
            } else {
                colorScheme.surface.toArgb()
            }
            window.navigationBarColor = colorScheme.surface.toArgb()
            // For dark theme, status bar icons should be light
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars =
                !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}