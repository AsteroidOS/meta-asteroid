#! /bin/sh

set -e

ANDROID_USB="/sys/class/android_usb/android0"

log_info () {
	echo "[INFO] $@"
}

start_usb () {
	echo "0" > $ANDROID_USB/enable

	log_info "Starting adb mode"

	manufacturer="$(cat /system/build.prop | grep -o 'ro.product.manufacturer=.*' | cut -d'=' -f 2)"
	model="$(cat /system/build.prop | grep -o 'ro.product.model=.*' | cut -d'=' -f 2)"
	serial="$(cat /proc/cmdline | sed 's/.*androidboot.serialno=//' | sed 's/ .*//')"

	echo $manufacturer > $ANDROID_USB/iManufacturer
	echo $model        > $ANDROID_USB/iProduct
	echo $serial       > $ANDROID_USB/iSerial

	echo 18d1 > $ANDROID_USB/idVendor
	echo 0a03 > $ANDROID_USB/idProduct

	mkdir -p /dev/usb-ffs/adb
	mount -t functionfs adb /dev/usb-ffs/adb

	echo adb > $ANDROID_USB/f_ffs/aliases
	echo ffs,ecm,mtp > $ANDROID_USB/functions

	echo "1" > $ANDROID_USB/enable

	log_info "Initialized android_usb with $manufacturer $model $serial"
}

start_usb
