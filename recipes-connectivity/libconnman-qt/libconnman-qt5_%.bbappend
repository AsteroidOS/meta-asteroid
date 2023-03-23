FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-libconnman-qt-Fix-NetworkTechnology-objects-removal.patch file://0002-libconnman-qt-Fixup-warning-on-Qt-5.10.patch file://0003-libconnman-qt-Support-VPN-association-state.-JB-5944.patch file://0004-Version-1.2.48.patch file://0005-libconnman-qt-Build-without-module-prefix-by-default.patch file://0006-libconnman-qt-Warn-on-MeeGo-qml-import-name.-JB-5970.patch file://0007-libconnman-qt-Clarify-getTechnology-API-dangers.-JB-.patch file://0008-Wait-for-dbus-call-to-finish-in-NetworkTechnology.patch"

