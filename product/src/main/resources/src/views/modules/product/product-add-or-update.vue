<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="始发站" prop="originatingStation">
      <el-input v-model="dataForm.originatingStation" placeholder="始发站"></el-input>
    </el-form-item>
    <el-form-item label="经停站" prop="stopoverStation">
      <el-input v-model="dataForm.stopoverStation" placeholder="经停站"></el-input>
    </el-form-item>
    <el-form-item label="到达站" prop="arrivalStation">
      <el-input v-model="dataForm.arrivalStation" placeholder="到达站"></el-input>
    </el-form-item>
    <el-form-item label="载客容量" prop="passengerCapacity">
      <el-input v-model="dataForm.passengerCapacity" placeholder="载客容量"></el-input>
    </el-form-item>
    <el-form-item label="出发时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="出发时间"></el-input>
    </el-form-item>
    <el-form-item label="车次(标识码)" prop="trainNumber">
      <el-input v-model="dataForm.trainNumber" placeholder="车次(标识码)"></el-input>
    </el-form-item>
    <el-form-item label="到达时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="到达时间"></el-input>
    </el-form-item>
    <el-form-item label="删除状态【0->未删除；1->已删除】" prop="deleteStatus">
      <el-input v-model="dataForm.deleteStatus" placeholder="删除状态【0->未删除；1->已删除】"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          originatingStation: '',
          stopoverStation: '',
          arrivalStation: '',
          passengerCapacity: '',
          startTime: '',
          trainNumber: '',
          endTime: '',
          deleteStatus: ''
        },
        dataRule: {
          originatingStation: [
            { required: true, message: '始发站不能为空', trigger: 'blur' }
          ],
          stopoverStation: [
            { required: true, message: '经停站不能为空', trigger: 'blur' }
          ],
          arrivalStation: [
            { required: true, message: '到达站不能为空', trigger: 'blur' }
          ],
          passengerCapacity: [
            { required: true, message: '载客容量不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '出发时间不能为空', trigger: 'blur' }
          ],
          trainNumber: [
            { required: true, message: '车次(标识码)不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '到达时间不能为空', trigger: 'blur' }
          ],
          deleteStatus: [
            { required: true, message: '删除状态【0->未删除；1->已删除】不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/product/product/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.originatingStation = data.product.originatingStation
                this.dataForm.stopoverStation = data.product.stopoverStation
                this.dataForm.arrivalStation = data.product.arrivalStation
                this.dataForm.passengerCapacity = data.product.passengerCapacity
                this.dataForm.startTime = data.product.startTime
                this.dataForm.trainNumber = data.product.trainNumber
                this.dataForm.endTime = data.product.endTime
                this.dataForm.deleteStatus = data.product.deleteStatus
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/product/product/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'originatingStation': this.dataForm.originatingStation,
                'stopoverStation': this.dataForm.stopoverStation,
                'arrivalStation': this.dataForm.arrivalStation,
                'passengerCapacity': this.dataForm.passengerCapacity,
                'startTime': this.dataForm.startTime,
                'trainNumber': this.dataForm.trainNumber,
                'endTime': this.dataForm.endTime,
                'deleteStatus': this.dataForm.deleteStatus
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
