# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

SUMMARY = "Focalcrest USB ADB gadget"

LICENSE = "Apache-2.0 & MIT"
LIC_FILES_CHKSUM = " \
    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
"

SRC_URI = " \
    file://adbd-aarch64 \
    file://nsswitch.conf \
    file://focalcrest-usb-gadget \
    file://focalcrest-usb-gadget.service \
"

S = "${UNPACKDIR}"

inherit systemd

COMPATIBLE_HOST = "aarch64.*-linux"
PACKAGE_ARCH = "${TUNE_PKGARCH}"

ADBD_SHA256 = "4d374d9d57cf91e7f04e98fb6bd3fc91813c26202874b3d42619bd52ca23650c"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

SYSTEMD_SERVICE:${PN} = "focalcrest-usb-gadget.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
	printf '%s  %s\n' '${ADBD_SHA256}' '${UNPACKDIR}/adbd-aarch64' | sha256sum -c -
	install -Dm0755 ${UNPACKDIR}/adbd-aarch64 ${D}${bindir}/adbd
	install -Dm0644 ${UNPACKDIR}/nsswitch.conf ${D}${datadir}/rockchip-adbd/nsswitch.conf

	install -d ${D}${sbindir}
	install -m 0755 ${UNPACKDIR}/focalcrest-usb-gadget ${D}${sbindir}/

	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${UNPACKDIR}/focalcrest-usb-gadget.service \
		${D}${systemd_system_unitdir}/
}

FILES:${PN} = " \
    ${bindir}/adbd \
    ${sbindir}/focalcrest-usb-gadget \
    ${systemd_system_unitdir}/focalcrest-usb-gadget.service \
    ${datadir}/rockchip-adbd \
"

RDEPENDS:${PN} = "systemd"
RPROVIDES:${PN} = "rockchip-adbd android-tools-adbd"
RCONFLICTS:${PN} = "android-tools-adbd"
