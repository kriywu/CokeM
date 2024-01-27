# ViewPager + Navigate 的生命周期
ViewPager 中的 Fragment 会受到 offscreenPageLimit 参数的影响。
初始化
MusicFragment onAttach:
MusicFragment onCreate:
MusicFragment onViewCreated:
MusicFragment onStart:
MusicFragment onResume:
FeedFragment onAttach:
FeedFragment onCreate:
FeedFragment onViewCreated:
FeedFragment onStart:
ProfileFragment onAttach:
ProfileFragment onCreate:
ProfileFragment onViewCreated:
ProfileFragment onStart:
切换Tab
MusicFragment onPause:
FeedFragment onResume:
经过测试发现，如果 offscreenPageLimit = 1，那么第三个 Fragment 并不会立即初始化，这种情况下一些加载耗时的操作不应该直接写在 onResume 之前
MusicFragment onAttach:
MusicFragment onCreate:
MusicFragment onViewCreated:
MusicFragment onStart:
MusicFragment onResume:
FeedFragment onAttach:
FeedFragment onCreate:
FeedFragment onViewCreated:
FeedFragment onStart: 