# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE:rk3568-mixtile-edge2 = "rk3568-mixtile-edge2"

SRC_URI:append:edge2 = " \
    file://defconfig \
    file://rk3568-mixtile-edge2.dts \
"

do_configure:prepend:edge2() {
	install -m 0644 ${UNPACKDIR}/rk3568-mixtile-edge2.dts \
		${S}/arch/arm64/boot/dts/rockchip/
	if ! grep -q "rk3568-mixtile-edge2.dtb" \
			${S}/arch/arm64/boot/dts/rockchip/Makefile; then
		echo 'dtb-$(CONFIG_ARCH_ROCKCHIP) += rk3568-mixtile-edge2.dtb' \
			>> ${S}/arch/arm64/boot/dts/rockchip/Makefile
	fi
}

COMPATIBLE_MACHINE:rk3588-mixtile-blade3 = "rk3588-mixtile-blade3"

SRC_URI:append:blade3 = " \
    file://defconfig \
    file://rk3588-mixtile-blade3.dts \
    file://0001-drm-bridge-dw-hdmi-qp-select-SND_SOC_HDMI_CODEC.patch \
"

do_configure:prepend:blade3() {
	install -m 0644 ${UNPACKDIR}/rk3588-mixtile-blade3.dts \
		${S}/arch/arm64/boot/dts/rockchip/
	if ! grep -q "rk3588-mixtile-blade3.dtb" \
			${S}/arch/arm64/boot/dts/rockchip/Makefile; then
		echo 'dtb-$(CONFIG_ARCH_ROCKCHIP) += rk3588-mixtile-blade3.dtb' \
			>> ${S}/arch/arm64/boot/dts/rockchip/Makefile
	fi
}

COMPATIBLE_MACHINE:rk3588-mixtile-core3588e = "rk3588-mixtile-core3588e"

SRC_URI:append:core3588e = " \
    file://defconfig \
    file://rk3588-mixtile-core3588e.dts \
    file://0001-drm-bridge-dw-hdmi-qp-select-SND_SOC_HDMI_CODEC.patch \
    file://0002-drm-rockchip-dw-hdmi-qp-honor-hpd-inverted.patch \
    file://0003-drm-analogix-dp-support-downstream-dp-connector.patch \
"

do_configure:prepend:core3588e() {
	install -m 0644 ${UNPACKDIR}/rk3588-mixtile-core3588e.dts \
		${S}/arch/arm64/boot/dts/rockchip/
	if ! grep -q "rk3588-mixtile-core3588e.dtb" \
			${S}/arch/arm64/boot/dts/rockchip/Makefile; then
		echo 'dtb-$(CONFIG_ARCH_ROCKCHIP) += rk3588-mixtile-core3588e.dtb' \
			>> ${S}/arch/arm64/boot/dts/rockchip/Makefile
	fi
}
