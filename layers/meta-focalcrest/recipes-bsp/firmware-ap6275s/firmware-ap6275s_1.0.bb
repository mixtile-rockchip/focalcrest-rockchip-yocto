# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

SUMMARY = "AP6275S (BCM43752A2) WiFi/BT firmware"
DESCRIPTION = "Upstream linux-firmware ships no 43752 at all. Vendor names are \
mapped to the ones brcmfmac and btbcm ask for."

LICENSE = "Firmware-broadcom_bcm43xx"
LICENSE_FLAGS = "commercial"
LIC_FILES_CHKSUM = "file://LICENCE.broadcom_bcm43xx;md5=3160c14df7228891b868060e1951dfbc"
NO_GENERIC_LICENSE[Firmware-broadcom_bcm43xx] = "LICENCE.broadcom_bcm43xx"

SRC_URI = "\
    file://LICENCE.broadcom_bcm43xx \
    file://fw_bcm43752a2_ag_apsta.bin \
    file://nvram_ap6275s.txt \
    file://clm_bcm43752a2_ag.blob \
    file://BCM4362A2.hcd \
"

S = "${UNPACKDIR}"

inherit allarch

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware/brcm
	install -m 0644 ${UNPACKDIR}/fw_bcm43752a2_ag_apsta.bin \
		${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43752-sdio.bin
	install -m 0644 ${UNPACKDIR}/nvram_ap6275s.txt \
		${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43752-sdio.txt
	install -m 0644 ${UNPACKDIR}/clm_bcm43752a2_ag.blob \
		${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43752-sdio.clm_blob
	install -m 0644 ${UNPACKDIR}/BCM4362A2.hcd \
		${D}${nonarch_base_libdir}/firmware/brcm/
}

FILES:${PN} = "${nonarch_base_libdir}/firmware/brcm"

INHIBIT_DEFAULT_DEPS = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
EXCLUDE_FROM_SHLIBS = "1"

RDEPENDS:${PN} += "linux-firmware-broadcom-license"
