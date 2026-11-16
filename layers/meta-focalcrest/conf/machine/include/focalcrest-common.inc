# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

MACHINEOVERRIDES =. "focalcrest:"

IMAGE_FSTYPES:append = " ext4 tar.zst"

WKS_FILE = "focalcrest-emmc.wks.in"
FC_ROOTFS_EXTRA_SPACE ?= "64"
WICVARS:append = " FC_ROOTFS_EXTRA_SPACE"

MACHINE_FEATURES:append = " usbhost usbgadget rtc vfat"
MACHINE_EXTRA_RRECOMMENDS += "kernel-modules"

# Boot through a custom FIT bootcmd instead of extlinux
UBOOT_EXTLINUX = "0"
MACHINE_ESSENTIAL_EXTRA_RDEPENDS:remove = "u-boot-extlinux"

UBOOT_SIGN_ENABLE ?= "0"
FIT_GENERATE_KEYS ?= "0"
