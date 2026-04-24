FILESEXTRAPATHS:prepend := "${THISDIR}/qttools:"
SRC_URI:append = " \
        file://0001-Build-kmap2qmap-tool.patch \
        file://0002-kmap2qmap-Map-MenuKB-key.patch \
        file://0003-kmap2qmap-Map-Sleep-key.patch \
"
